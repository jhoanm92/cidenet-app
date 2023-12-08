export class PageResponse<D> {
    content: D[];
    totalElements: number;
    totalPages: number;
    last: boolean;
    number: number;
    size: number;
    numberOfElements: number;
    first: boolean;
    empty: false;
}
