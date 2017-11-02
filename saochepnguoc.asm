.Model Small
.Stack 100
.Data
Str1 DB 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'
Tbao DB 'ban sao cua chuoi goc:', 10,13, '$'
Str2 DB 8 DUP (' ')
     DB '$'
.Code
MAIN proc
MOV AX, @Data
MOV DS, AX
MOV ES, AX 

LEA SI, Str1

LEA DI, Str2+7


CLD 

MOV CX, 8
LAP:
MOVSB
SUB DI,2
LOOP LAP


LEA DX, Tbao

MOV AH, 9
INT 21H
LEA DX, Str2 

INT 21H
MOV AH, 4CH
INT 21H
MAIN Endp
END MAIN