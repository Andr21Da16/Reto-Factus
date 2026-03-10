export interface BrandingSettingsDataRequest {
  appName: string,
  primaryColor: string,
  secondaryColor: string,
  textColor: string,
  buttonsColor: string,
  fontFamily: string,
  darkModeEnabled: boolean,
}

export interface BrandingSettingsDataResponse {
  appName: string,
  primaryColor: string,
  secondaryColor: string,
  textColor: string,
  buttonsColor: string,
  logoUrl: string,
  fontFamily: string,
  darkModeEnabled: boolean,
}

export interface SettingsResponse{
  brandingSettings: BrandingSettingsDataResponse
}

export interface AppSettingsResponse {
  id: number,
  companyName: string,
  settings: SettingsResponse
}