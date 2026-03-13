
import { useSettingsContext } from "@/context/SettingsContext.tsx";

import { useAuth } from "@/context/AuthContext.tsx";
import BrandingHeader from "#/sidebar/BrandingHeader.tsx";
import { useMatches } from "react-router";
import type { ClassNameProps, MatchWithHandle } from "@/types";
import ScreenHeader from "#/sidebar/ScreenHeader.tsx";
import Loader from "#/common/Loader.tsx";
import NavItems from "#/sidebar/NavItems.tsx";
import SeparationBar from "#/common/SeparationBar.tsx";
import { use } from "react";


const Sidebar = ({className} : ClassNameProps) => {
  const {user} = useAuth()
  const {brandingSettings} = useSettingsContext();
  const matches = useMatches() as MatchWithHandle[];

  const pageMatch = matches.find((m) => m.handle?.screenTitle);

  const screenTitle = pageMatch?.handle?.screenTitle ?? "";



  if (!brandingSettings) {
    return (
      <Loader/>
    )
  }

  return (
    <aside className={`max-w-70 p-3 flex flex-col ${className}`}>
      <BrandingHeader settings={brandingSettings} user={user}/>
      <ScreenHeader
        appName={brandingSettings?.appName}
        screenTitle={screenTitle}
        firstName={user?.firstName}
      />

      <NavItems />


      <div className="relative mt-auto flex flex-col h-fit gap-6 w-full">
        <SeparationBar/>
        <div>
          <div className="flex items-center size-12 rounded-full overflow-hidden shrink-0 justify-center">
            {user?.photoUrl ? <img className="flex w-full h-full object-cover" src={user.photoUrl} alt={user.firstName} /> :
              <div className="flex flex-col w-full object-cover items-center ">
                U
              </div>
            }
          </div>
        </div>
      </div>
    </aside>
  )
}
export default Sidebar;