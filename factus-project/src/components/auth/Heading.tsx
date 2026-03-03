import {Sparkles} from 'lucide-react'

const Heading = () => {
  return (
    <div className="space-y-4 mb-8">
      <div className="inline-flex items-center gap-2 bg-rose-500/30 backdrop-blur-sm border border-rose-400/30 rounded-full px-3 py-1.5">
        <Sparkles className="w-3 h-3 text-rose-200" />
        <span className="text-rose-100 text-xs font-medium">Todo-en-Uno</span>
      </div>
      <h2 className="text-3xl lg:text-4xl font-bold text-white leading-tight">
        Bienvenido de<br />
        <span className="text-transparent bg-clip-text bg-gradient-to-r from-rose-200 via-red-200 to-pink-200">nuevo</span>
      </h2>
      <p className="text-rose-100/80 leading-relaxed">
        Plataforma de gestión de productos con integración de facturación electrónica mediante Factus, desarrollada como parte del Reto Factus de Halltech.
      </p>
    </div>
  )
}
export default Heading;