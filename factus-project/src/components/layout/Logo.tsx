import {Building2} from 'lucide-react'

const Logo = () => {
  return (
    <div className="flex items-center gap-3 mb-8">
      <div className="relative">
        <div className="absolute inset-0 bg-gradient-to-br from-red-400 to-rose-600 rounded-xl blur-lg opacity-60 animate-pulse"></div>
        <div className="relative w-12 h-12 bg-gradient-to-br from-red-500 to-rose-600 rounded-xl flex items-center justify-center shadow-xl">
          <Building2 className="w-7 h-7 text-white" />
        </div>
      </div>
      <div>
        <h1 className="text-2xl font-bold text-white">Reto Factus</h1>
        <span className="text-rose-200 text-xs">Gestión Empresarial</span>
      </div>
    </div>
  )
}
export default Logo;