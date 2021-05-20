import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ApirestService } from '../Services/apirest.service';
import { Materia } from '../model/materia';

@Component({
  selector: 'app-materias',
  templateUrl: './materias.component.html',
  styleUrls: ['./materias.component.css']
})
export class MateriasComponent implements OnInit {

  materia = new Materia();
  submitted = false;
  msgError = '';

  constructor(private service: ApirestService, private router: Router) { }

  ngOnInit(): void {
  }

  create(){
    const data = {

      nrc: this.materia.nrc,
      materia : this.materia.materia,
      facultad : this.materia.facultad,
      horasCredito: this.materia.horasCredito,
      campus: this.materia.campus,
      periodoAsociado : this.materia.periodoAsociado,
      metodoEducativo : this.materia.metodoEducativo

    };

    this.service.createMaterias(data)
      .subscribe(
        response => {
          this.submitted=true;
          console.log(response);
        },
        error => {
          this.msgError  = error.message +' \n '+ error.error.message;
          console.log(error);
        });

  }

  newMateria() {
    this.submitted = false;
    this.materia.nrc = null;
    this.materia.facultad = null;
    this.materia.horasCredito = null;
    this.materia.campus = null;
    this.materia.periodoAsociado = null;
    this.materia.metodoEducativo = null;
  }
  volver(){
    this.router.navigate(["/home"])
  }


}
