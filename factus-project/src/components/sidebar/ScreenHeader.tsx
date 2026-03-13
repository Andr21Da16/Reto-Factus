import { ChevronRight } from "lucide-react";
import SeparationBar from "#/common/SeparationBar.tsx";

interface ScreenHeaderProps {
  appName?: string
  screenTitle: string
  firstName?: string
}

const ScreenHeader = ({ appName, screenTitle, firstName }: ScreenHeaderProps) => {
  return (
    <div className="mt-6 md:mt-8 flex flex-col gap-3 md:gap-3 bg-inherit">

      <div className="text-sm md:text-[12px] text-gray-600 flex items-center gap-1">
        <span>{appName}</span>
        <ChevronRight size={11} className="relative top-px" />
        <span className="text-black font-medium">{screenTitle}</span>
      </div>

      <h2 className="text-2xl md:text-[24px] w-fit font-semibold leading-tight">
        Welcome Back, <br/> {firstName} 👋
      </h2>

      <SeparationBar />

    </div>
  )
}

export default ScreenHeader