export class Pageable {
  page: number;
  size: number;
  sort: string;
  totalElements: number;
  pageSizeOptions: number[];
  constructor({
    page = 0,
    size = 10,
    totalElements = 0,
    pageSizeOptions = [10, 5],
    sort = '',
  } = {}) {
    this.page = page;
    this.size = size;
    this.totalElements = totalElements;
    this.pageSizeOptions = pageSizeOptions;
    this.sort = sort;
  }
}
