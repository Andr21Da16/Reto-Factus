

const Background = () => {
  return (
    <div className="absolute inset-0 bg-gradient-to-br from-red-950 via-rose-900 to-red-950">
      {/* Animated gradient orbs */}
      <div className="absolute top-0 left-0 w-150 h-150 bg-red-500/30 rounded-full blur-[120px] animate-pulse"></div>
      <div className="absolute bottom-0 right-0 w-175 h-175 bg-rose-500/20 rounded-full blur-[120px] animate-pulse" style={{ animationDelay: '1s' }}></div>
      <div className="absolute top-1/2 left-1/2 -translate-x-1/2 -translate-y-1/2 w-125 h-125 bg-pink-500/20 rounded-full blur-[100px] animate-pulse" style={{ animationDelay: '2s' }}></div>

      {/* Grid pattern overlay */}
      <div className="absolute inset-0 bg-[linear-gradient(rgba(255,255,255,0.03)_1px,transparent_1px),linear-gradient(90deg,rgba(255,255,255,0.03)_1px,transparent_1px)] bg-[size:50px_50px]"></div>

      {/* Floating particles */}
      <div className="absolute top-20 left-20 w-2 h-2 bg-white/20 rounded-full animate-float"></div>
      <div className="absolute top-40 right-32 w-3 h-3 bg-rose-400/30 rounded-full animate-float" style={{ animationDelay: '0.5s' }}></div>
      <div className="absolute bottom-32 left-40 w-2 h-2 bg-red-400/30 rounded-full animate-float" style={{ animationDelay: '1s' }}></div>
      <div className="absolute top-60 right-20 w-2 h-2 bg-pink-400/30 rounded-full animate-float" style={{ animationDelay: '1.5s' }}></div>
      <div className="absolute bottom-40 right-60 w-3 h-3 bg-white/10 rounded-full animate-float" style={{ animationDelay: '2s' }}></div>

      {/* Geometric shapes */}
      <div className="absolute top-32 right-1/4 w-32 h-32 border border-white/5 rounded-3xl rotate-12 animate-spin-slow"></div>
      <div className="absolute bottom-32 left-1/4 w-40 h-40 border border-white/5 rounded-full animate-spin-slow" style={{ animationDelay: '1s', animationDirection: 'reverse' }}></div>
      <div className="absolute top-1/2 right-20 w-24 h-24 border border-white/5 rounded-2xl -rotate-6 animate-spin-slow" style={{ animationDelay: '0.5s' }}></div>
    </div>
  )
}

export default Background;