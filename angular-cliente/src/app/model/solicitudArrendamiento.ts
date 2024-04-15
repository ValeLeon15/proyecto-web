export class solicitudArrendamiento {
    constructor(
        public id: number,
        public idSolicitudArrendamiento: number,
        public idPropiedad: number,
        public idAUsuarioArrendatario: number,
        public fechaInicial: Date,
        public fechaFinal: Date,
        public cantPersonas: number,
        public estado: string,
    ){}
}