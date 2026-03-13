import { Ellipsis, Mail } from "lucide-react";
import type { User } from "@/@types/Auth.type.ts";
import { useState } from "react";

interface IProps {
  user: User;
}
const UserInfo = ({user} : IProps) => {

  const [open, setOpen] = useState(false);
  return (
    <div className="flex gap-1 items-center shrink-0 overflow-hidden">
      <div className="flex items-center size-12 rounded-full overflow-hidden shrink-0 justify-center">
        {user?.photoUrl ? <img className="flex w-full h-full object-cover" src={user.photoUrl} alt={user.firstName} /> :
          <div className="flex flex-col w-full object-cover items-center ">
            U
          </div>
        }
      </div>
      <div className="flex flex-col ml-2 max-w-32">
        <span className="font-bold truncate">{ `${user?.firstName.split(" ")[0]} ${user?.lastName.split(" ")[0]}`}</span>
        <div className="flex items-center gap-2 shrink-0 ">
          <span className="rounded-full size-5 flex bg-gradient-to-br from-green-200 to-green-400 items-center justify-center"><Mail size={10}/></span>
          <span className="align-middle text-gray-600 font-medium text-[13px] truncate ">{user?.email}</span>
        </div>
      </div>
      <button onClick={() => setOpen(prev => !prev)} className="ml-auto rounded-full p-px hover:bg-gray-200" >
        <Ellipsis />
      </button>

      {open && (
        <div className="absolute bottom-10 right-0 flex flex-col bg-red-800 p-2 rounded">
          asdsa
        </div>
      )}
    </div>

  )
}

export default UserInfo;