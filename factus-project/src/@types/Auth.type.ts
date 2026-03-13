export interface User {
  id: number
  photoUrl?: string
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
