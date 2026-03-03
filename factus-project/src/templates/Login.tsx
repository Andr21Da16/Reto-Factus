
import BackgroundLogin from "#/layout/BackgroundLogin.tsx";
import Logo from "#/layout/Logo.tsx";
import Heading from "#/auth/Heading.tsx";
import {Lock} from 'lucide-react'
import type { FeaturesProps } from "@/types";
import Feature from "#/layout/Feature.tsx";
import LoginForm from "#/auth/LoginForm.tsx";
import { Navigate, useLocation} from "react-router";
import { useAuth } from "@/context/AuthContext.tsx";
import { features } from "@/util/constants.ts";




const Login = () => {


    const {  isAuthenticated } = useAuth();
    const location = useLocation();
    console.log(isAuthenticated);
    // Si venimos de un redirect, usamos location.state?.from
    const from = (location.state as { from?: string })?.from || "/";


    // Redirige automáticamente si ya está autenticado
    if (isAuthenticated) return <Navigate to={from} />;

    return (
        <div className="min-h-screen relative flex items-center justify-center p-4 overflow-hidden">
           <BackgroundLogin />

            {/*Login form*/}
            <div className="relative z-10 w-full max-w-5xl">
                <div className="bg-white/10 backdrop-blur-2xl border border-white/20 rounded-3xl shadow-2xl overflow-hidden">
                    <div className="grid md:grid-cols-4">
                        {/*Left*/}
                        <div className="md:col-span-2 bg-gradient-to-br from-red-600/40 to-rose-600/40 backdrop-blur-sm p-8 lg:p-10 border-r border-white/10">
                            {/*Logo*/}
                            <Logo/>
                            {/*Heading*/}
                            <Heading/>
                            {/*Features*/}
                            <div className="space-y-3 mb-8">
                                {
                                    features.map((feature: FeaturesProps, index: number) => {

                                        const Icon = feature.icon;
                                        return (
                                          <Feature
                                            key={index}
                                            mainText={feature.mainText}
                                            description={feature.description}>
                                              {Icon && <Icon className="w-5 h-5 text-rose-200" />}
                                          </Feature>
                                        )
                                    })
                                }
                            </div>
                        </div>
                        {/*Right*/}
                        <div className="md:col-span-2 p-8 lg:p-10 flex flex-col justify-center">
                            {/* Form Header */}
                            <div className="mb-6">
                                <div className="flex items-center gap-3 mb-4">
                                    <div className="w-12 h-12 bg-gradient-to-br from-red-500 to-rose-600 rounded-xl flex items-center justify-center shadow-lg shadow-red-500/50">
                                        <Lock className="w-6 h-6 text-white" />
                                    </div>
                                    <div>
                                        <h3 className="text-2xl font-bold text-white">Iniciar Sesión</h3>
                                        <p className="text-rose-200/80 text-sm">Accede a tu cuenta</p>
                                    </div>
                                </div>
                            </div>

                            <LoginForm/>

                        </div>


                    </div>
                </div>
            </div>

        </div>
    )
}

export default Login;