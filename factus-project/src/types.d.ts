interface Meta {
    page: number,
    size: number,
    totalElements: number,
    totalPages: number,
    first: boolean,
    last: boolean
}

export interface ApiResponse<T> {
    timeStamp: string,
    success : boolean,
    message: string,
    description?: string,
    data?: T,
    meta?: Meta
}

export interface User {
    id: number
    firstName: string,
    lastName: string,
    email: string,
    company: string,
    role: string
}

export interface LoginRequest {
    email: string,
    password: string
}

export interface RegisterRequest {
    firstName: string,
    lastName: string,
    phone: string,
    email: string,
    password: string,
    rolId: number
}

export interface LoginResponse {
    token: string,
    user: User
}

export interface FeaturesProps {
    icon?: React.ComponentType<{ className?: string }>,
    children?: React.ReactNode,
    mainText: string,
    description: string,
}

