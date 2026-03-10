import type { ApiResponse } from "@/types";

export const unwrapResponse = <T>(response: ApiResponse<T>): T => {
  if (!response.success || !response.data) {
    throw new Error(response.message);
  }

  return response.data;
};