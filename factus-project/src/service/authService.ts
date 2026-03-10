import type { LoginRequest, LoginResponse, RegisterRequest, User } from "@/@types/Auth.type.ts";
import api from "@/api/axios.ts";
import type { ApiResponse } from "@/types";

export const loginUser = async ({ email, password } : LoginRequest) => {
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

export const registerUser = async (data : RegisterRequest) => {
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