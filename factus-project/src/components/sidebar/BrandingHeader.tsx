import { Crown, Lock } from "lucide-react";
import type { BrandingSettingsDataResponse } from "@/@types/AppSettings.type.ts";
import type { User } from "@/@types/Auth.type.ts";

interface BrandingHeaderProps {
  settings?: BrandingSettingsDataResponse,
  user: User | null,
}
const BrandingHeader = ({ settings, user }: BrandingHeaderProps) =>{
  return (
    <div className="flex items-center w-full md:w-fit gap-2 bg-inherit">

      {/* Logo */}
      <div className="flex w-9 h-9 md:w-11 md:h-11 rounded-full overflow-hidden shrink-0">
        <img
          className="w-full h-full object-cover"
          src={settings?.logoUrl}
          alt={settings?.appName}
        />
      </div>

      {/* App name + Private */}
      <div className="flex flex-col leading-tight">
        <h2 className="text-[12px] md:text-[14px] xl:text-[16px] 2xl:text-[18px] font-bold">
          {settings?.appName}
        </h2>
        <span className="flex items-center gap-1 text-gray-700 font-semibold text-xs">
          <Lock size={10} /> Private
        </span>
      </div>

      {/* Role Badge */}
      <div className="flex items-center gap-1.5 bg-gradient-to-br from-white via-green-200 to-green-400 rounded-xl py-1 px-2 ml-auto">
        <span className="flex items-center gap-1 text-[12px] font-bold">
          <Crown size={16} /> {user?.role.toLowerCase()}
        </span>
      </div>

    </div>
  )

}
export default BrandingHeader;