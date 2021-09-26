import {Injectable} from "@angular/core";
import {environment} from "./environment";

@Injectable({
              providedIn: 'root'
            })

export class EnvironmentClass {
  private _settlementUrl = `${environment.apiServerUrl}` + '/settlement';

  get settlementUrl(): string {
    return this._settlementUrl;
  }

  private _employeeUrl = `${environment.apiServerUrl}` + '/employee';

  get employeeUrl(): string {
    return this._employeeUrl;
  }
}
