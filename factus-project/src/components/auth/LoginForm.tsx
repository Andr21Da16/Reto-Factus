import { useState } from "react";
import {Mail, Lock, EyeOff, Eye, ArrowRight, AlertCircle} from 'lucide-react'
import { useAuth } from "@/context/AuthContext.tsx";
import { useLocation, useNavigate } from "react-router";
const LoginForm = () =>{

  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [showPassword, setShowPassword] = useState(false);
  const {login, loading, error} = useAuth()
  const navigate = useNavigate();
  const location = useLocation();
  const from = location.state?.from || '/';

  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault(); // evita recargar la página

    if (email && password) {
      try {
        await login({email, password});
        navigate(from);
      } catch (err) {
        // Error is handled in context and exposed via error state
        setEmail("");
        setPassword("");
      }
    }
  };
  return (
    <form onSubmit={handleSubmit} className="space-y-4 mb-6">
      {/* Email Input */}
      <div>
        <label htmlFor="email" className="block text-sm font-semibold text-white mb-2">
          Correo Electrónico
        </label>
        <div className="relative group">
          <Mail className="absolute left-4 top-1/2 -translate-y-1/2 w-5 h-5 text-rose-300/60 group-focus-within:text-rose-300 transition z-10" />
          <input
            id="email"
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            className="w-full pl-11 pr-4 py-3.5 bg-white/10 backdrop-blur-sm border-2 border-white/20 rounded-xl text-white placeholder-rose-200/50 focus:bg-white/20 focus:border-rose-400 focus:ring-4 focus:ring-rose-500/20 outline-none transition"
            placeholder="ejemplo@empresa.com"
            required
          />
        </div>
      </div>

      {/* Password Input */}
      <div>
        <label htmlFor="password" className="block text-sm font-semibold text-white mb-2">
          Contraseña
        </label>
        <div className="relative group">
          <Lock className="absolute left-4 top-1/2 -translate-y-1/2 w-5 h-5 text-rose-300/60 group-focus-within:text-rose-300 transition z-10" />
          <input
            id="password"
            type={showPassword ? 'text' : 'password'}
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            className="w-full pl-11 pr-12 py-3.5 bg-white/10 backdrop-blur-sm border-2 border-white/20 rounded-xl text-white placeholder-rose-200/50 focus:bg-white/20 focus:border-rose-400 focus:ring-4 focus:ring-rose-500/20 outline-none transition"
            placeholder="••••••••••"
            required
          />
          <button
            type="button"
            onClick={() => setShowPassword(!showPassword)}
            className="absolute right-4 top-1/2 -translate-y-1/2 text-rose-300/60 hover:text-rose-300 transition z-10"
          >
            {showPassword ? <EyeOff className="w-5 h-5" /> : <Eye className="w-5 h-5" />}
          </button>
        </div>
      </div>

      {/* Remember & Forgot */}
      <div className="flex items-center justify-between text-sm">
        <label className="flex items-center gap-2 cursor-pointer group">
          <input
            type="checkbox"
            className="w-4 h-4 rounded border-white/30 bg-white/10 text-red-600 focus:ring-red-500 cursor-pointer"
          />
          <span className="text-rose-200/80 group-hover:text-white transition">
                      Recordarme
                    </span>
        </label>
        <button
          type="button"
          className="text-rose-200/80 hover:text-white font-medium transition"
        >
          ¿Olvidaste tu contraseña?
        </button>
      </div>

      {/* Error Message */}
      {error && (
        <div className="bg-red-500/20 backdrop-blur-sm border-2 border-red-400/50 rounded-xl p-3 flex items-center gap-3 text-white">
          <AlertCircle className="w-5 h-5 flex-shrink-0" />
          <div>
            <p className="font-semibold text-sm">Error de autenticación</p>
            <p className="text-xs text-rose-100">{error}</p>
          </div>
        </div>
      )}

      {/* Submit Button */}
      <button
        type="submit"
        disabled={loading}
        className="w-full relative group overflow-hidden bg-gradient-to-r from-red-500 to-rose-600 text-white py-3.5 rounded-xl font-semibold shadow-lg shadow-red-500/50 hover:shadow-xl hover:shadow-red-500/60 hover:scale-[1.02] transition-all disabled:opacity-50 disabled:cursor-not-allowed disabled:hover:scale-100"
      >
        <div className="absolute inset-0 bg-gradient-to-r from-red-600 to-rose-700 translate-y-full group-hover:translate-y-0 transition-transform duration-300"></div>
        <span className="relative flex items-center justify-center gap-2">
                    {loading ? (
                      <>
                        <div className="w-5 h-5 border-2 border-white/30 border-t-white rounded-full animate-spin"></div>
                        Iniciando sesión...
                      </>
                    ) : (
                      <>
                        Iniciar Sesión
                        <ArrowRight className="w-5 h-5 group-hover:translate-x-1 transition-transform" />
                      </>
                    )}
                  </span>
      </button>

    </form>
  )
}
export default LoginForm