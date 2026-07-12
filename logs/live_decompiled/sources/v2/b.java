package V2;

import p2.q;

/* loaded from: classes.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2580a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* JADX INFO: Access modifiers changed from: private */
    public static final int b(byte[] bArr, int i3) {
        byte b3;
        int i4;
        int length = bArr.length;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        loop0: while (i5 < length) {
            byte b4 = bArr[i5];
            if (b4 >= 0) {
                int i8 = i7 + 1;
                if (i7 == i3) {
                    return i6;
                }
                if ((b4 != 10 && b4 != 13 && ((b4 >= 0 && b4 < 32) || (Byte.MAX_VALUE <= b4 && b4 < 160))) || b4 == 65533) {
                    return -1;
                }
                i6 += b4 < 65536 ? 1 : 2;
                i5++;
                while (true) {
                    i7 = i8;
                    if (i5 < length && (b3 = bArr[i5]) >= 0) {
                        i5++;
                        i8 = i7 + 1;
                        if (i7 == i3) {
                            return i6;
                        }
                        if ((b3 == 10 || b3 == 13 || ((b3 < 0 || b3 >= 32) && (Byte.MAX_VALUE > b3 || b3 >= 160))) && b3 != 65533) {
                            i6 += b3 < 65536 ? 1 : 2;
                        }
                    }
                }
            } else {
                if ((b4 >> 5) == -2) {
                    int i9 = i5 + 1;
                    if (length <= i9) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b5 = bArr[i9];
                    if ((b5 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    int i10 = (b5 ^ 3968) ^ (b4 << 6);
                    if (i10 < 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    i4 = i7 + 1;
                    if (i7 == i3) {
                        return i6;
                    }
                    if ((i10 != 10 && i10 != 13 && ((i10 >= 0 && i10 < 32) || (127 <= i10 && i10 < 160))) || i10 == 65533) {
                        return -1;
                    }
                    i6 += i10 < 65536 ? 1 : 2;
                    q qVar = q.f12810a;
                    i5 += 2;
                } else if ((b4 >> 4) == -2) {
                    int i11 = i5 + 2;
                    if (length <= i11) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b6 = bArr[i5 + 1];
                    if ((b6 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b7 = bArr[i11];
                    if ((b7 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    int i12 = ((b6 << 6) ^ ((-123008) ^ b7)) ^ (b4 << 12);
                    if (i12 < 2048) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    if (55296 <= i12 && i12 < 57344) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    i4 = i7 + 1;
                    if (i7 == i3) {
                        return i6;
                    }
                    if ((i12 != 10 && i12 != 13 && ((i12 >= 0 && i12 < 32) || (127 <= i12 && i12 < 160))) || i12 == 65533) {
                        return -1;
                    }
                    i6 += i12 < 65536 ? 1 : 2;
                    q qVar2 = q.f12810a;
                    i5 += 3;
                } else {
                    if ((b4 >> 3) != -2) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    int i13 = i5 + 3;
                    if (length <= i13) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b8 = bArr[i5 + 1];
                    if ((b8 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b9 = bArr[i5 + 2];
                    if ((b9 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    byte b10 = bArr[i13];
                    if ((b10 & 192) != 128) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    int i14 = (((b10 ^ 3678080) ^ (b9 << 6)) ^ (b8 << 12)) ^ (b4 << 18);
                    if (i14 > 1114111) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    if (55296 <= i14 && i14 < 57344) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    if (i14 < 65536) {
                        if (i7 == i3) {
                            return i6;
                        }
                        return -1;
                    }
                    i4 = i7 + 1;
                    if (i7 == i3) {
                        return i6;
                    }
                    if ((i14 != 10 && i14 != 13 && ((i14 >= 0 && i14 < 32) || (127 <= i14 && i14 < 160))) || i14 == 65533) {
                        return -1;
                    }
                    i6 += i14 < 65536 ? 1 : 2;
                    q qVar3 = q.f12810a;
                    i5 += 4;
                }
                i7 = i4;
            }
        }
        return i6;
    }

    public static final char[] c() {
        return f2580a;
    }
}
