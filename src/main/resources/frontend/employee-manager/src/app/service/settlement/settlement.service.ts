import {Injectable} from '@angular/core';
import {EnvironmentClass} from "../../../environments/environment.class";
import {Settlement} from "../../model/settlement/settlement";
import {HttpClient} from "@angular/common/http";

@Injectable({
              providedIn: 'root'
            })

export class SettlementService {

  private settlementUrl = this.environmentClass.settlementUrl;

  constructor(private http: HttpClient,
              private environmentClass: EnvironmentClass) { }

  public getSettlements(): Promise<Settlement[]> {
    return this.http.get<Settlement[]>(`${this.settlementUrl}`).toPromise();
  }

  public getSettlement(id: number): Promise<Settlement> {
    return this.http.get<Settlement>(`${this.settlementUrl}/${id}`).toPromise();
  }
}
