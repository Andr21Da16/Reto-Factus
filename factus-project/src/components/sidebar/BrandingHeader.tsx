import { Crown, Lock } from "lucide-react";
import type { BrandingSettingsDataResponse } from "@/@types/AppSettings.type.ts";
import type { User } from "@/@types/Auth.type.ts";

interface BrandingHeaderProps {
  settings?: BrandingSettingsDataResponse,
  user: User | null,
}
const BrandingHeader = ({ settings, user }: BrandingHeaderProps) =>{
  return (
    <div className="grid grid-cols-1 md:grid-cols-4 items-center justify-center w-full md:w-fit gap-4">

      {/* Logo */}
      <div className="flex w-16 h-16 rounded-full overflow-hidden md:col-span-1 mx-auto md:mx-0">
        <img
          className="w-full h-full object-cover"
          src={settings?.logoUrl}
          alt={settings?.appName}
        />
      </div>

      {/* App name + Private */}
      <div className="flex flex-col items-center md:items-start w-fit md:col-span-2 mx-auto">
        <h2 className="text-lg md:text-xl font-bold text-center md:text-left">
          {settings?.appName}
        </h2>
        <span className="flex items-center gap-1.5 text-gray-700 font-semibold ">
            <Lock size={18} /> Private
          </span>
      </div>

      {/* Role Badge */}
      <div className="flex items-center justify-center md:justify-end gap-1.5 bg-gradient-to-br from-white via-green-200 to-green-400 rounded-xl py-1 pr-1 pl-1 md:col-span-1 mx-auto md:mx-0">
          <span className="flex items-center gap-1 text-[12px] font-bold">
            <Crown size={18} /> {user?.role.toLowerCase()}
          </span>
      </div>

    </div>
  )

}
export default BrandingHeader;