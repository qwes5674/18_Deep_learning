from fastapi import FastAPI
from routers import translate
import uvicorn

app = FastAPI()

app.include_router(translate.router)

# if __name__ == "__main__":
#     uvicorn.run(app, post="8000" )

# uvicorn main:app --reload --port=8000