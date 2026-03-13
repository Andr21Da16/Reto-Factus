import type { ClassNameProps } from "@/types";

const Header = ({className} : ClassNameProps) =>{
  return (
    <div className={`w-full h-full ${className}`}></div>
  )
}
export default Header;