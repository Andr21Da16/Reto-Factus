import { useQuery } from "@tanstack/react-query";

import { getSettings } from "@/service/appSettingService.ts";


export const useSettings = () => {
  return useQuery({
    queryKey: ["settings"],
    queryFn: getSettings ,
  });
};