import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Employee} from "../../model/employee/employee";
import {EnvironmentClass} from "../../../environments/environment.class";

@Injectable({
              providedIn: 'root'
            })

export class EmployeeService {

  private employeeUrl = this.environmentClass.employeeUrl;

  constructor(private http: HttpClient,
              private environmentClass: EnvironmentClass) {}

  public getEmployees(): Promise<Employee[]> {
    return this.http.get<Employee[]>(`${this.employeeUrl}`).toPromise();
  }

  public insertEmployee(employee: Employee): Promise<Employee> {
    return this.http.post<Employee>(`${this.employeeUrl}`, employee)
               .toPromise();
  }

  public updateEmployee(employee: Employee): Promise<Employee> {
    return this.http.put<Employee>(`${this.employeeUrl}`, employee).toPromise();
  }

  public deleteEmployee(id: number): Promise<void> {
    return this.http.delete<void>(`${this.employeeUrl}/${id}`).toPromise();
  }
}
