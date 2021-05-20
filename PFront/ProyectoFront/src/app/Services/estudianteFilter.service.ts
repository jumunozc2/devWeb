import { Pipe, PipeTransform } from '@angular/core';

@Pipe({ name: 'listFilter2'})
export class ListFilterPipe2 implements PipeTransform {

    transform(list: any[], filterText: string): any {
        return list ? list.filter(item => item.codigo.search(new RegExp(filterText, 'i')) > -1) : [];
    }
}