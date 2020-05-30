import {Deserializable} from '../deserializable.model';

export class UserProfile implements Deserializable {
  public id: number;
  public username: string;
  public firstName: string;
  public email: string;
  public lastName: string;
 

  constructor(id: number, lastName: string, firstName: string, email: string, username: string) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.email = email;
    this.username = username;
  }


  deserialize(input: any): this {
    return Object.assign(this, input);
  }


  getEmail() {
    return this.email;
  }
}
