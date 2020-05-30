import {Deserializable} from '../deserializable.model';

export class User implements Deserializable {
  public id: number;
  public name: string;
  public surname: string;
  public email: string;
  public username: string;
  public password: string;
  public authorities: any[];

  constructor(data: any) {
    this.id = data.id;
    this.name = data.firstName;
    this.surname = data.lastName;
    this.email = data.email;
    this.username = data.username;
    this.authorities = data.authorities;
  }


  deserialize(input: any): this {
    return Object.assign(this, input);
  }


  getEmail() {
    return this.email;
  }
}
