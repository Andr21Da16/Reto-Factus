
import { useSettingsContext } from "@/context/SettingsContext.tsx";

import { useAuth } from "@/context/AuthContext.tsx";
import BrandingHeader from "#/sidebar/BrandingHeader.tsx";
import { useMatches } from "react-router";
import type { ClassNameProps, MatchWithHandle } from "@/types";
import ScreenHeader from "#/sidebar/ScreenHeader.tsx";


const Sidebar = ({className} : ClassNameProps) => {
  const {user} = useAuth()
  const {brandingSettings} = useSettingsContext();

  const matches = useMatches() as MatchWithHandle[];

  const pageMatch = matches.find((m) => m.handle?.screenTitle);

  const screenTitle = pageMatch?.handle?.screenTitle ?? "";

  return (
    <aside className={`max-w-80 p-4 bg-white ${className}`}>
      <BrandingHeader settings={brandingSettings} user={user}/>

      <ScreenHeader
        appName={brandingSettings?.appName}
        screenTitle={screenTitle}
        firstName={user?.firstName}
      />

    </aside>
  )
}
export default Sidebar;