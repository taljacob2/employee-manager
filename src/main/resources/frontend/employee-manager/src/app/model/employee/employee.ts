/**
 * This is a POJO class.
 */
import {Settlement} from "../settlement/settlement";

export class Employee {
  id!: number;
  name!: string;
  email!: string;
  jobTitle!: string;
  phone!: string;
  imageURL!: string;
  code!: string;
  settlementEntity!: Settlement;
}
