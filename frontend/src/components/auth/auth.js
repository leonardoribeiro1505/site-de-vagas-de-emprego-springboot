export const TOKEN_KEY = "@vagas-Token";
export const EMAIL = "@email";
export const isAuthenticated = () => localStorage.getItem(TOKEN_KEY, EMAIL) !== null;
export const getToken = () => localStorage.getItem(TOKEN_KEY, EMAIL);

export const login = data => {
    localStorage.setItem(TOKEN_KEY, data.token);
    localStorage.setItem(EMAIL, data.email);
};

export const logout = () => {
    localStorage.removeItem(TOKEN_KEY);
    localStorage.removeItem(EMAIL);
};