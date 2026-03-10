import { createContext, useContext, useEffect, useMemo } from "react";
import { useSettings } from "@/hooks/useSettings.ts";
import type { BrandingSettingsDataResponse, SettingsResponse } from "@/@types/AppSettings.type.ts";

interface SettingsContextType {
  setting?: SettingsResponse;
  brandingSettings?: BrandingSettingsDataResponse;
  darkMode: boolean;
  error: Error | null;
  isLoading: boolean;
}

const SettingsContext = createContext<SettingsContextType | undefined>(undefined);

export const SettingsProvider: React.FC<{ children: React.ReactNode }> = ({ children }) => {
  const { data, error, isLoading } = useSettings();
  const storedDarkMode = localStorage.getItem("darkMode") === "true";


  const value = useMemo(
    () => ({
      setting: data?.settings,
      brandingSettings: data?.settings?.brandingSettings,
      darkMode:
        data?.settings?.brandingSettings?.darkModeEnabled ??
        storedDarkMode ??
        false,
      error: error ?? null,
      isLoading,
    }),
    [data, error, isLoading]
  );

  useEffect(() => {
    localStorage.setItem("darkMode", value.darkMode ? "true" : "false");
  }, [value.darkMode]);


  return (
    <SettingsContext.Provider value={value}>
      {children}
    </SettingsContext.Provider>
  );
};


export const useSettingsContext = () => {
  const context = useContext(SettingsContext);

  if (!context) {
    throw new Error("useSettingsContext must be used within SettingsProvider");
  }

  return context;

};