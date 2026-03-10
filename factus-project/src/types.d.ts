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


export interface FeaturesProps {
    icon?: React.ComponentType<{ className?: string }>,
    children?: React.ReactNode,
    mainText: string,
    description: string,
}

export interface MatchWithHandle {
    handle?: RouteHandle;
}

export interface ClassNameProps {
    className?: string;
}

