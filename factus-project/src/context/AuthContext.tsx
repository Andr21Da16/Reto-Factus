import api from "@/api/axios";
import type { ApiResponse, LoginRequest, LoginResponse, RegisterRequest, User } from "@/types";
import Cookies from "js-cookie";
import { useMutation } from "@tanstack/react-query";
import { createContext, useContext ,useEffect, useState } from "react";

interface AuthContextType {
    user: User | null;
    login: (LoginRequest : LoginRequest) => Promise<void>;
    register: (RegisterRequest : RegisterRequest) => Promise<void>;
    logout: () => void;
    isAuthenticated: boolean;
    loading: boolean;
    error: string | null;
}

const loginUser = async ({ email, password } : LoginRequest) => {
    const payload = {
        email : email,
        password : password,
    }
    const response = await api.post<ApiResponse<LoginResponse>>("/auth/sign-in", payload);

    if (!response.data.data) {
        throw new Error(response.data.message);
    }
    return response.data.data;
}

const registerUser = async (data : RegisterRequest) => {
    const payload = {
        firstName: data.firstName,
        lastName: data.lastName,
        email: data.email,
        password: data.password,
        phone: data.phone,
        rolId: data.rolId,
    }

    const response = await api.post<ApiResponse<User>>("/auth/sign-up", payload);

    if (!response.data.data) {
        throw new Error(response.data.message);
    }
    return response.data.data;
}

const AuthContext = createContext<AuthContextType | undefined>(undefined)


export const AuthProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {

    const [user, setUser] = useState<User | null>(null);

     useEffect(() => {
        const validateToken = async () => {
            const storedUser = Cookies.get('user');
            const token = Cookies.get('token');

            if (storedUser && token) {
                try {
                    // Validate token by making a lightweight API call
                    // Using the products endpoint as a validation check
                    await api.get('/auth/me');
                    // If successful, token is valid
                    setUser(JSON.parse(storedUser));
                } catch (err) {
                    // Token is invalid or expired, clear everything
                    Cookies.remove('user');
                    Cookies.remove('token');
                    setUser(null);
                }
            }
        };

        validateToken();
    }, []);

    useEffect(() => {
        const handleUnauthorized = () => {
            setUser(null);
        };

        window.addEventListener('unauthorized', handleUnauthorized);
        return () => window.removeEventListener('unauthorized', handleUnauthorized);
    }, []);

    const mutationLogin = useMutation({
        mutationFn: loginUser,
        onSuccess: (data) => {
            Cookies.set("token", data.token);
            Cookies.set("user", JSON.stringify(data.user));
            setUser(data.user);
        },
    });

    const mutationRegister = useMutation({
        mutationFn: registerUser,
    });


    const login = async (loginRequest: LoginRequest) => {
        await mutationLogin.mutateAsync(loginRequest);
    };

    const register = async (registerRequest: RegisterRequest) => {
        await mutationRegister.mutateAsync(registerRequest);
    };

    const logout = () => {
        setUser(null);
        Cookies.remove('user');
        Cookies.remove('token');
    };

    const loading = mutationLogin.isPending || mutationRegister.isPending;

    const error =
      (mutationLogin.error as Error | null)?.message ||
      (mutationRegister.error as Error | null)?.message ||
      null;

    return (
        <AuthContext.Provider value={{ user, login, register, logout, isAuthenticated: !!user, loading, error }}>
            {children}
        </AuthContext.Provider>
    );


};

export const useAuth = () => {
    const context = useContext(AuthContext);
    if (context === undefined) {
        throw new Error('useAuth must be used within an AuthProvider');
    }
    return context;
};