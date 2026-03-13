/// <reference types="vite/client" />

import type { LucideIcon } from "lucide-react";

interface ImportMetaEnv {
    readonly VITE_BASE_URL: string;
}


interface ImportMeta{
    readonly env: ImportMetaEnv;
}

