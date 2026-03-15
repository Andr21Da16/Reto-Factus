import type { FeaturesProps, NavItem } from "@/types";
import { Shield, Zap, Users, Settings, Home, LogOut, User, CreditCard, Info } from "lucide-react";

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



export const navItems: NavItem[] = [
  {
    id: "menu",
    label: "Menu",
    children: [
      {
        id: "dashboard",
        label: "Dashboard",
        icon: Home,
        path: "/dashboard",
      },
    ],
  },
  {
    id: "options",
    label: "Options",
    children: [
      {
        id: "settings",
        label: "Settings",
        icon: Settings,
        path: "/settings",
      },
      {
        id: "logout",
        label: "Logout",
        icon: LogOut,
        path: "/login",
        action: "logout",
      }
    ],
  },
];

export const MenuUserItems : NavItem[] = [
  {
    id: "profile",
    label: "My profile",
    icon: User
  },
  {
    id: "billing",
    label: "Billing",
    icon: CreditCard
  },
  {
    id: "support",
    label: "Support",
    icon: Info
  }
]