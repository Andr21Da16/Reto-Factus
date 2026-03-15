
import { useSettingsContext } from "@/context/SettingsContext.tsx";

import { useAuth } from "@/context/AuthContext.tsx";
import BrandingHeader from "#/sidebar/BrandingHeader.tsx";
import { useMatches } from "react-router";
import type { ClassNameProps, MatchWithHandle } from "@/types";
import ScreenHeader from "#/sidebar/ScreenHeader.tsx";
import Loader from "#/common/Loader.tsx";
import NavItems from "#/sidebar/NavItems.tsx";

import SideBarFooter from "#/sidebar/SideBarFooter.tsx";


const Sidebar = ({className} : ClassNameProps) => {
  const {user} = useAuth()
  const {brandingSettings} = useSettingsContext();
  const matches = useMatches() as MatchWithHandle[];

  const pageMatch = matches.find((m) => m.handle?.screenTitle);

  const screenTitle = pageMatch?.handle?.screenTitle ?? "";



  if (!brandingSettings || !user?.photoUrl) {
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


      <SideBarFooter user={user} />


    </aside>
  )
}
export default Sidebar;