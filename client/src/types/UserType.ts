type LoginType = {
    userName: string,
    password: string
}

interface RegisterType extends LoginType {
    email: string
}

type responseType = {
    accessToken: string;
    refreshToken: string;
    message: string;
};

type AuthenticationType = {
    accessToken: string,
    refreshToken: string
}