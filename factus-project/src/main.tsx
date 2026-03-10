
import { createRoot } from 'react-dom/client'
import './index.css'

import { RouterProvider } from 'react-router'
import { router } from './routes/router.tsx'
import { QueryClientProvider } from '@tanstack/react-query';
import { queryClient } from './config/config.ts';
import { AuthProvider } from "./context/AuthContext";
import { SettingsProvider } from "@/context/SettingsContext.tsx";


createRoot(document.getElementById('root')!).render(
  <QueryClientProvider client={queryClient}>
    <AuthProvider>
      <SettingsProvider>
        <RouterProvider router={router}/>
      </SettingsProvider>
    </AuthProvider>
  </QueryClientProvider>
)
