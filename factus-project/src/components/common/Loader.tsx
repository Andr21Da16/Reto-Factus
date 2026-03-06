import Background from "#/layout/Background.tsx";

const Loader = () => {
  return (
    <div className="flex items-center justify-center h-screen">
      <Background/>
      <div className="w-16 h-16 border-4 border-t-[#E94E3C] border-b-[#F5A623] border-l-transparent border-r-transparent rounded-full animate-spin"></div>
    </div>
  );
};

export default Loader;