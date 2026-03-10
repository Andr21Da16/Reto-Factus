import { ChevronRight } from "lucide-react";

interface ScreenHeaderProps {
  appName?: string
  screenTitle: string
  firstName?: string
}

const ScreenHeader = ({ appName, screenTitle, firstName }: ScreenHeaderProps) => {
  return (
    <div className="mt-10 md:mt-12 flex flex-col gap-3 md:gap-4">

      <div className="text-sm md:text-base text-gray-600 flex items-center gap-2">
        <span>{appName}</span>
        <span className="font-semibold"><ChevronRight size={16}/> </span>
        <span className="text-black font-medium">{screenTitle}</span>
      </div>

      <h2 className="text-2xl md:text-3xl font-semibold leading-tight">
        Welcome Back, {firstName} 👋
      </h2>

      <div className="w-full h-px bg-gray-200 mt-3 md:mt-4"></div>

    </div>
  )
}

export default ScreenHeader