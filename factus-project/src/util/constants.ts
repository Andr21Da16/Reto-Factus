import type { FeaturesProps } from "@/types";
import {Shield, Zap, Users} from 'lucide-react'

export const BASE_URL: string = import.meta.env.VITE_BASE_URL;

export const features: FeaturesProps[] = [
  {
    icon: Shield,
    mainText: "Seguridad Avanzada",
    description: "Encriptación de datos"
  },
  {
    icon: Zap,
    mainText: "Tiempo Real",
    description: "Actualización instantánea"
  },
  {
    icon: Users,
    mainText: "Colaboración",
    description: "Trabajo en equipo"
  }
]