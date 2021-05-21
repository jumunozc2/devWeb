import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';
import { Estudiante } from '../model/estudiante';
import { Materia } from '../model/materia';

@Injectable({
  providedIn: 'root'
})
export class ApirestService {

  constructor(private http:HttpClient) {}

  currentUser$ = new BehaviorSubject("");
  currentPass$ = new BehaviorSubject("");


  private baseUrl = 'http://localhost:8080/api/v1/materia';
  private baseUrl2 = 'http://localhost:8080/api/v1/Estudiante';

    public login(username: string,password:string){

      this.currentUser$.next(username);
      this.currentPass$.next(password);
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.get("http://localhost:8080/api/v1/",{headers,responseType:'test' as 'json'});
    }

    public sms(data: any): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.post("http://localhost:8080/api/v1/SMS", data,{headers});
    }

    get(id: String): Observable<Materia> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.get<Materia>(`${this.baseUrl}/${id}`,{headers});
    }
    get2(id: String): Observable<Estudiante> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.get<Estudiante>(`${this.baseUrl2}/${id}`,{headers});
    }

    update(id: string, data: any): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.put(`${this.baseUrl}/${id}`, data,{headers});
    }

    update2(id: string, data: any): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.put(`${this.baseUrl2}/${id}`, data,{headers});
    }
  
    delete(id: string): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.delete(`${this.baseUrl}/${id}`,{headers});
    }
    delete2(id: string): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.delete(`${this.baseUrl2}/${id}`,{headers});
    }


    public getMaterias(){

      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();

      console.log(username+" "+password);
      

      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.get("http://localhost:8080/api/v1/books",{headers});
    }

    public getBooks() : Observable<Materia[]>{
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.get<Materia[]> ("http://localhost:8080/api/v1/books",{headers});
      }
      public getBooks2() : Observable<Estudiante[]>{
        let username = this.currentUser$.getValue();
        let password  = this.currentPass$.getValue();
        
        const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
        return this.http.get<Estudiante[]> ("http://localhost:8080/api/v1/Estudiante",{headers});
        }
    public createMaterias(data: any): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.post("http://localhost:8080/api/v1/materia", data,{headers});
    }

    public createEstudiantes(data: any): Observable<any> {
      let username = this.currentUser$.getValue();
      let password  = this.currentPass$.getValue();
      
      const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
      return this.http.post("http://localhost:8080/api/v1/Estudiante", data,{headers});
    }
   public createUser(data: any): Observable<any> {
    let username = this.currentUser$.getValue();
    let password  = this.currentPass$.getValue();
    
    const headers = new HttpHeaders({Authorization: 'Basic '+btoa(username+":"+password)})
    return this.http.post("http://localhost:8080/api/v1/user", data,{headers});
  }
}
