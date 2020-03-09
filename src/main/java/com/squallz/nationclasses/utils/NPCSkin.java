package com.squallz.nationclasses.utils;

import com.squallz.nationclasses.enums.ClassType;

public class NPCSkin {

    public String getTexture(ClassType classType){
        switch(classType) {
            case CLERIC:
                return "";
            case NECROMANCER:
                return "";
            case KNIGHT:
                return "eyJ0aW1lc3RhbXAiOjE1ODMyNzcwOTAzMDIsInByb2ZpbGVJZCI6IjdhYzdiNjZhMWVhMDRlYjc4NGFmM2NiZDBkNmY1NzM3IiwicHJvZmlsZU5hbWUiOiIxNW9iZXIiLCJzaWduYXR1cmVSZXF1aXJlZCI6dHJ1ZSwidGV4dHVyZXMiOnsiU0tJTiI6eyJ1cmwiOiJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzRkZTIyZmZhZWExYjgwODJkOTUzZTBjNWMxZjk2NDczNjcxZDQ2NzEwMmIyZjhkNzY5YTUyZmFiNGJhNzg1OGYifX19";
            default:
                break;
        }
        return "";
    }

    public String getSignature(ClassType classType) {
        switch(classType) {
            case CLERIC:
                return "";
            case NECROMANCER:
            case KNIGHT:
                return "MzCVqqwlKDweqF2zpfc3nGaLLtnJe7mKa3wrMpz+arNTZxSSldLXHCJE4NpL8LerwMiBagvHhGJ5ZxUNowAOKrtM74RpF6gG03wkfzcFS6/CsaS8CjuJEPUseRqpeFXXbN+j5I5Y2rk7OhO69jIUYzaB5bvKB9tsMzb1W31cLp5i5Dq9XGieEjL1S3f+UqZebZWrsUFdUAuxY5nUKGJVwjQ8MyhI6TopLZW4R2yqSKmtyqo+sR866NpMkGq1XjugoQUS2VWsvl9J5WaEzYJpNYODQ/u3GjBPeZyiz7triQ0hkqcsfSYKFADhCBqR4Znk6Mw4QW1muMzH0I6w/EKa28jdGYT53ZDElI54koNf5Av29QSeThJU1d6gaevNQzunUaskseojDkt3bknf9xpLF67ZKruj1AiSb/v9UWyGSCfoRlys10TfZu3sbyAUd6LE2DgZix7dxA1cbZh0MANak4JGuQ8fCP/3ovOUj29UJXe9Iuso+Dh44o4M3DGmZBDcAXu1BIQVN6PGKfQwC/lS6g0Nx9RqlbEVBQe/OzG/0Ela11+TV8++MSCXsyTnOlQKIkf2puiw89yNc8PmJmWPLKV9hMfVHd2hc+ALlYBM44XNATL7zPdQAt9ew5Zr375LfltXa52iNhyDTjfh9oCH5CDVBW/hmMhUKxKVV8OHAoo=";
            default:
                break;
        }
        return "";
    }

}
