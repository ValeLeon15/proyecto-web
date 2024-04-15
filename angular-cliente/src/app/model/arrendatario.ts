export class Arrendatario {
    constructor(
        public id: number,
        public nombre: string,
        public apellido: string,
        public correo: string,
        public telefono: number,
        public contrasena: string,
    ){}
}