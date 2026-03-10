import api from "@/api/axios.ts";
import type { ApiResponse } from "@/types";
import type {
  AppSettingsResponse,
  BrandingSettingsDataRequest,
  BrandingSettingsDataResponse,
} from "@/@types/AppSettings.type.ts";
import { unwrapResponse } from "@/api/apiHelpers.ts";

export const getSettings = async (): Promise<AppSettingsResponse> =>{

  const {data} = await api.get<ApiResponse<AppSettingsResponse>>("/settings");

  return unwrapResponse(data);


}

export const getBrandingData = async () :Promise<BrandingSettingsDataResponse> =>{  

  const {data} = await api.get<ApiResponse<BrandingSettingsDataResponse>>("/settings/branding");
  return unwrapResponse(data);
}

export const createBrandingData = async (
  brandingData :BrandingSettingsDataRequest, file: File):Promise<BrandingSettingsDataResponse> =>{

  const formData = new FormData();
  formData.append("branding", JSON.stringify(brandingData));
  formData.append("file", file);

  const {data} = await api.post<ApiResponse<BrandingSettingsDataResponse>>("/settings/branding", formData);

  return unwrapResponse(data);


}

export const updateBrandingData = async (
  brandingData :BrandingSettingsDataRequest, file: File
): Promise<BrandingSettingsDataResponse> => {
  const formData = new FormData();
  formData.append("branding", JSON.stringify(brandingData));
  formData.append("file", file);

  const {data} = await api.put<ApiResponse<BrandingSettingsDataResponse>>("/settings/branding", formData);

  return unwrapResponse(data);
}