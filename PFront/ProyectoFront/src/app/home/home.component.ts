import { Component, OnInit } from '@angular/core';
import { ApirestService } from '../Services/apirest.service';
import { Router } from '@angular/router';
import { Materia } from '../model/materia';
import { ModalDismissReasons, NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { MateriasComponent } from '../materias/materias.component';
import { Estudiante } from '../model/estudiante';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  users: any;

  bookSet: Materia[];
  bookFil: Materia[];
  isbnBook : '';
  currentBook : any;
  currentIndex = -1;
  collectionSize: number;
  searchTerm: string;
  closeModal: string;
  msgError = '';

  bookSet2: Estudiante[];
  bookFil2: Estudiante[];
  isbnBook2 : '';
  currentBook2 : any;
  currentIndex2 = -1;
  collectionSize2: number;
  searchTerm2: string;
  closeModal2: string;
  msgError2 = '';

  constructor(private service: ApirestService,private router:Router,private modalService: NgbModal) { }

  ngOnInit()  {
    this.refreshList();
  }
  logout(){
    this.router.navigate(["/login"])
  }

  addMateria(){
    this.router.navigate(["/materias"])
  }

  triggerModal(content:any, val:Materia) {
    this.currentBook = val
    this.retrieveBook(this.currentBook.nrc)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {
      this.closeModal = `Closed with: ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason(res)}`;
    });
  }

  triggerModal2(content:any, val:Estudiante) {
    this.currentBook2 = val
    this.retrieveBook2(this.currentBook2.codigo)
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((res) => {
      this.closeModal = `Closed with: ${res}`;
    }, (res) => {
      this.closeModal = `Dismissed ${this.getDismissReason2(res)}`;
    });
  }





  
  private getDismissReason(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  private getDismissReason2(reason: any): string {
    if (reason === ModalDismissReasons.ESC) {
      return 'by pressing ESC';
    } else if (reason === ModalDismissReasons.BACKDROP_CLICK) {
      return 'by clicking on a backdrop';
    } else {
      return  `with: ${reason}`;
    }
  }

  search(value: string): void {
    this.bookFil = this.bookSet.filter((val) => val.materia.toLowerCase().includes(value));
    this.collectionSize = this.bookFil.length;
  }
  search2(value: string): void {
    this.bookFil2 = this.bookSet2.filter((val) => val.codigo.toLowerCase().includes(value));
    this.collectionSize2 = this.bookFil2.length;
  }

  retrieveBooks(): void {
    this.service.getBooks()
      .subscribe(
        data => {
          this.bookSet = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  retrieveBooks2(): void {
    this.service.getBooks2()
      .subscribe(
        data => {
          this.bookSet2 = data;
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }

  retrieveBook(val:string): void {
    this.service.get(val)
      .subscribe(
        data => {
          this.currentBook = data;
          console.log(data);
        },
        error => {
          this.msgError =  error.message +' \n '+ error.error.message;
          console.log(error);
        });
  }
  retrieveBook2(val:string): void {
    this.service.get2(val)
      .subscribe(
        data => {
          this.currentBook2 = data;
          console.log(data);
        },
        error => {
          this.msgError =  error.message +' \n '+ error.error.message;
          console.log(error);
        });
  }

  updateBook(): void {
   this.service.update(this.currentBook.nrc, this.currentBook)
      .subscribe(
        data => {
          this.refreshList();
          console.log(data);
        },
        error => {
          console.log(error);
        });
  }
  updateBook2(): void {
    this.service.update2(this.currentBook2.codigo, this.currentBook2)
       .subscribe(
         data => {
           this.refreshList2();
           console.log(data);
         },
         error => {
           console.log(error);
         });
   }

  deleteBook(val1:string): void {
    this.service.delete(val1)
       .subscribe(
         data => {
           this.refreshList();
           console.log(data);
         },
         error => {
           console.log(error);
         });
   }
   deleteBook2(val1:string): void {
    this.service.delete2(val1)
       .subscribe(
         data => {
           this.refreshList2();
           console.log(data);
         },
         error => {
           console.log(error);
         });
   }

  setActiveBook(book : Materia, index : number): void {
    this.currentBook = book;
    this.currentIndex = index
  }

  setActiveBook2(book : Estudiante, index : number): void {
    this.currentBook2 = book;
    this.currentIndex2 = index
  }

  refreshList(): void {
    this.retrieveBooks();
    this.retrieveBooks2();
    
  }
  refreshList2(): void {
    this.retrieveBooks2();
    
  }
}
