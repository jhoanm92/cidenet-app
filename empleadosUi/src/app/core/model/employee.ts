import { Country } from "./country";

export interface Employee {
    id: number;
    name: string;
    surname: string;
    extraName: string;
    country: Country;
    email: string;
}
