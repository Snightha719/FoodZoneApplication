export class Food {
    id!: number;
    name!: string;
    description!: string;
    price!: number;
    type!: string;
    imageUrl!: string;
    restaurant!: {
      rid: number;
      name: string;
      address: string;
    };
  }
  