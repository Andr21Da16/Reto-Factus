import type { FeaturesProps } from "@/types";


const Feature = ({children, mainText, description}: FeaturesProps) => {
  return (
    <div className="flex items-center gap-3 group">
      <div className="w-10 h-10 bg-white/10 rounded-lg flex items-center justify-center group-hover:bg-white/20 transition">
        {children}
      </div>
      <div>
        <p className="text-white font-medium text-sm">{mainText}</p>
        <p className="text-rose-200/70 text-xs">{description}</p>
      </div>
    </div>
  )
}
export default Feature;