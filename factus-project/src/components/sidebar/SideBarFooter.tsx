import { Ellipsis, Mail } from "lucide-react";
import type { User } from "@/@types/Auth.type.ts";
import { useEffect, useRef, useState } from "react";
import SeparationBar from "#/common/SeparationBar.tsx";
import MenuUser from "#/sidebar/MenuUser.tsx";


interface IProps {
  user: User;
}
const SideBarFooter = ({user} : IProps) => {

  const [open, setOpen] = useState(false);
  const menuRef = useRef<HTMLDivElement>(null);
  useEffect(() => {
    const handleClickOutside = (event: MouseEvent) => {
      if (!menuRef.current?.contains(event.target as Node)) {
        setOpen(false);
      }
    };

    document.addEventListener("mousedown", handleClickOutside);

    return () => {
      document.removeEventListener("mousedown", handleClickOutside);
    };
  }, []);
  return (

    <div className="relative mt-auto flex flex-col w-full gap-4">
      <SeparationBar />

      <div className="flex items-center gap-2 w-full min-w-0">
        {/* AVATAR */}
        <div className="flex items-center justify-center size-11 md:size-12 rounded-full overflow-hidden shrink-0 bg-gray-200">
          {user?.photoUrl ? (
            <img
              className="w-full h-full object-cover"
              src={user.photoUrl}
              alt={user.firstName}
            />
          ) : (
            <span className="font-semibold text-sm">
          {user?.firstName?.[0]}
        </span>
          )}
        </div>
        {/* USER INFO */}
        <div className="flex flex-col ml-1 flex-1 min-w-0">
      <span className="font-bold text-sm truncate">
        {`${user?.firstName?.split(" ")[0]} ${user?.lastName?.split(" ")[0]}`}
      </span>
          <div className="flex items-center gap-2 min-w-0">
        <span className="rounded-full p-1 flex shrink-0 bg-gradient-to-br from-green-200 to-green-400 items-center justify-center">
          <Mail size={10} />
        </span>
            <span className="text-gray-600 font-medium text-[12px] md:text-[13px] truncate">
          {user?.email}
        </span>
          </div>
        </div>
        {/* MENU BUTTON */}
        <div ref={menuRef} className="relative shrink-0">
          <button
            onClick={() => setOpen(prev => !prev)}
            className="rounded-full p-1 hover:bg-gray-200 transition-colors"
          >
            <Ellipsis />
          </button>
          <MenuUser open={open} user={user} />
        </div>
      </div>
    </div>
  )
}

export default SideBarFooter;