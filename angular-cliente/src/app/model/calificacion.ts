export class Calificacion {
    constructor(
        public id: number,
        public idSolicitudArrendamiento: number,
        public calificacionArrendatario: number,
        public comentarioArrendatario: string,
        public calificacionPropiedad: number,
        public comentarioPropiedad: string,
        public fechaCalificacion: Date,
    ){}
}